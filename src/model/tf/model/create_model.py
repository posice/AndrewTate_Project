import nltk
from nltk.stem.lancaster import LancasterStemmer
stemmer = LancasterStemmer()

import numpy as np
import pandas as pd
import json
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.layers import Input, Embedding, LSTM , Dense,GlobalMaxPooling1D,Flatten, Dropout
from tensorflow.keras.models import Model, Sequential
from tensorflow import keras
import matplotlib.pyplot as plt
import random

#Importing Json
with open('intense.json') as content:
  intents = json.load(content)

words = []
classes = []
documents = []
ignore_words = ['?']

#Loading data, tokenizing
for intent in intents['intents']:
    for pattern in intent['input']:
        w = nltk.word_tokenize(pattern)
        words.extend(w)
        documents.append((w, intent['tag']))
        if intent['tag'] not in classes:
            classes.append(intent['tag'])
words = [stemmer.stem(w.lower()) for w in words if w not in ignore_words]
words = sorted(list(set(words)))

classes = sorted(list(set(classes)))
print (len(documents), "documents")
print (len(classes), "classes", classes)
print (len(words), "unique stemmed words", words)

#Adding Words and Classes to to the JSON
intents["words"] = words
intents["classes"] = classes

with open("intense.json", "w") as jsonFile:
    json.dump(intents, jsonFile)

#Getting training-Data from words, documents and classes into training
training = []
output_empty = [0] * len(classes)
for doc in documents:
    bag = []
    pattern_words = doc[0]
    pattern_words = [stemmer.stem(word.lower()) for word in pattern_words]
    for w in words:
        bag.append(1) if w in pattern_words else bag.append(0)
    
    output_row = list(output_empty)
    output_row[classes.index(doc[1])] = 1
    
    training.append([bag, output_row])

random.shuffle(training)
training = np.array(training)
train_x = list(training[:,0])
train_y = list(training[:,1])

print(train_x)
print(train_y)

#Creating the Model (Sequential, #1 layer: 128 neurons, #2 layer: 64 neurons, output: index)
model = Sequential()
model.add(Dense(128, input_shape=(len(train_x[0]),), activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(len(train_y[0]), activation='softmax'))

#training
model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
train = model.fit(np.array(train_x),np.array(train_y),epochs=300)

#saving
model.save("./model.h5")