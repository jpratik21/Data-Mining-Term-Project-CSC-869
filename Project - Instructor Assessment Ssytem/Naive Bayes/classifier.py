## Pratik Jaiswal
## CSC 869: Data Mining, Dr. Hui Yang
## Term Project

## Python program for Naive Bayesian Classifier
## Running instructions: python classifier.py instruction.data instruction.test

#!/usr/bin/python

import csv
import sys

cnt_words = 0
entitys_cnt = 0
stat_words = {} 

# To keep track of word count in each class
stat_words_target = {} 

# To keep track of cntber of lines in each class
stat_class = {} 

def classification(document, target_block):
    global stat_words, cnt_words, stat_words_target, entitys_cnt

    pc = {}
    pwc = {}
    
    pw = 1
    prob = {}
    

    for word in document:
        if word not in stat_words:
            continue
        pw = pw * float(sum(stat_words[word].values())) / cnt_words

    for target in target_block:
        pc[target] = stat_class[target] / float(entitys_cnt)
        for word in document:
            if word not in stat_words:
                continue 
            target_wrd_cnt = stat_words[word].get(target, 0)
            pwc[target] = pwc.get(target, 1) * float(target_wrd_cnt) / stat_words_target[target]

        prob[target] = (pwc[target] * pc[target]) / pw

    l = sorted(prob.items(), key = lambda i: i[1], reverse=True)
    print prob
    return l[0][0]

def training_helper(adultdataset, word_targets):
    global stat_words, cnt_words, stat_words_target, entitys_cnt, stat_class

    cnt = len(adultdataset)
    for entity in xrange(cnt):
        stat_class[word_targets[entity]] = stat_class.get(word_targets[entity], 0) + 1

        for i in xrange(len(adultdataset[entity])):
            word = adultdataset[entity][i]
            if not stat_words.has_key(word):
                stat_words[word] = {}

            target = word_targets[entity]

            cnt = stat_words[word].get(target, 0)
            stat_words[word][target] = cnt + 1

            stat_words_target[target] = stat_words_target.get(target, 0) + 1
            cnt_words += 1

    entitys_cnt = cnt

def result_verify(adultdataset, word_targets):
    cnt = len(adultdataset)
    target_block = set(word_targets)
    right = 0
    wrong = 0

    for entity in xrange(cnt):
        res = classification(adultdataset[entity], target_block)
        if res == word_targets[entity]:
            right = right + 1
        else:
            wrong = wrong + 1

    print 'Accepted = ', float(right) / cnt, ' Rejected = ', float(wrong) / cnt
            
def data_insert(fil):
    
    data = []
    targets = []
    reader = csv.reader(fil)
    
    for line in reader:
        d = [x.strip() for x in line]
        if '?' in d:
            continue

        if not len(d):
            continue
        
        data.append(d[:-1])
        targets.append(d[-1:][0])

    return data, targets

if __name__ == '__main__':
    if len(sys.argv) < 3:
        print './filename data_training.txt data_testing.txt'
        sys.exit(1)

    filename = sys.argv[1]
    fil = open(filename, 'r')
    
    data, target = data_insert(fil)
    training_helper(data, target)

    test_file = open(sys.argv[2], 'r')
    test_data, test_target = data_insert(test_file)

    result_verify(test_data, target)