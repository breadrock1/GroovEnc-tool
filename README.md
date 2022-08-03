# Grooven-tool

![GitHub](https://badgen.net/badge/icon/github?icon=github&label)
![version](https://img.shields.io/badge/version-1.1-blue)
[![Awesome](https://awesome.re/badge.svg)](https://awesome.re)

Grooven-tool is a simple tool for transforming encoded data into its canonical form, or for 
transforming raw data into various encoded and hashed forms. It is capable of intelligently 
recognizing several encoding formats using heuristic techniques.

Encoding is the process of putting a sequence of character’s (letters, numbers, punctuation, and 
symbols) into a specialized format which is used for efficient transmission or storage. Decoding is 
the opposite process of encoding the conversion of an encoded format back into the original format. 
Encoding and decoding can be used in data communications, networking, and storage.

There are 7 (at the moment) types of decoder format in Grooven-tool:

    Plain text
    Base64
    Hex
    Morse
    QrCode
    Rot13
    Vigenere

### Base64 algorithm

The Base64 algorithm is one of the algorithms for Encoding and Decoding an object into ASCII format, 
which is meant for the base number 64 or one of the methods used to encode the binary data. Base64 
Commonly used in various applications such as e-mail via MME, XML data, or for URL encoding purposes.

### Hex algorithm

The hexadecimal (also base 16 or simply hex) numeral system is a positional numeral system that 
represents numbers using a radix (base) of 16. Unlike the decimal system representing numbers 
using 10 symbols, hexadecimal uses 16 distinct symbols, most often the symbols "0"–"9" to represent 
values 0 to 9, and "A"–"F" (or alternatively "a"–"f") to represent values from 10 to 15.

### Morse algorithm

The Morse code is a method used in telecommunication to encode text characters as standardized 
sequences of two different signal durations, called dots and dashes, or dits and dahs. Morse code 
is named after Samuel Morse, one of the inventors of the telegraph.

### QrCode algorithm

The QR code (an initialism for quick response code) is a type of matrix barcode (or two-dimensional 
barcode) invented in 1994 by the Japanese automotive company Denso Wave. A barcode is a 
machine-readable optical label that can contain information about the item to which it is attached. 
In practice, QR codes often contain data for a locator, identifier, or tracker that points to a 
website or application. The QR code is case sensitive. It uses four standardized encoding modes 
(numeric, alphanumeric, byte/binary, and kanji) to store data efficiently; extensions may also be used.

### Rot13 algorithm

The Rot13 ("rotate by 13 places", sometimes hyphenated ROT-13) is a simple letter substitution 
cipher that replaces a letter with the 13th letter after it in the alphabet. ROT13 is a special 
case of the Caesar cipher which was developed in ancient Rome.

### Vigenere algorithm

The Vigenere cipher is a method of encrypting alphabetic text by using a series of interwoven 
Caesar ciphers, based on the letters of a keyword. It employs a form of polyalphabetic substitution.


## Setting up and Building

There is command to download and install dependencies and build groovy project:

```shell
gradle buildDependents && gradle build
```

You may build project to jar-file and run it like java application:

```shell
gradle jar
```

## Run project

```shell
gradle run
```
or 

```shell
groovy App.groovy
```

## LICENCE

MIT License

Copyright (c) 2021 Bread White

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
