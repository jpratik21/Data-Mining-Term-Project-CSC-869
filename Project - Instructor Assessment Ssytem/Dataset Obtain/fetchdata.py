# CSC 869: Term Project Data Fetch from ratemyprofessors.com
# Pratik Jaiswal

# Made use of scaperwiki - web-based platform for collaboratively building programs to extract and
# analyze public (online) data, in a wiki-like fashion. "Scraper" refers to screen scrapers, 
# programs that extract data from websites. "Wiki" means that any user with programming experience 
# can create or edit such programs for extracting new data, or for analyzing existing datasets.
# Automatically converts incoming documents to Unicode and outgoing documents to UTF-8. 

# Beautifulsoup: Python library for navigating, searching, and modifying a parse tree. It helps you to extract what you need.

import scraperwiki
from bs4 import BeautifulSoup
import string
import unicodedata
import time

# Headers are nothing but different factors/attributes that will affect overall instructor score
headers = ["Name","Department","Total Ratings","Overall Quality","Easiness","Hot"]

# Colleges is an array with a format collegeid:(collegename, pagenumber)
colleges = {"580":("MIT",16),"1222":("Yale",23),"181":("CMU",28), "1085":("UChicago",28),"1040":("Tufts",46), 
        "1350":("Duke",84),"1255":("UTexas",84),"953":("Stanford",32),"799":("Rice",17),"780":("Princeton",16)}


# This code will be responsible for fetching the data from below mentioned URL
for sid in colleges.keys():
    college,pages = colleges[sid]
    print college
    for i in xrange(1,pages+1):
        response = scraperwiki.scrape("http://www.ratemyprofessors.com/SelectTeacher.jsp?sid=%s&pageNo=%s" % (sid,str(i)))
        time.sleep(5)
        soup = BeautifulSoup(response)
        rows = soup.find_all("div",{"class":"entry odd vertical-center"})
        rows.extend(soup.find_all("div",{"class":"entry even vertical-center"}))
        for row in rows:
            columns = row.find_all('div')
            columns = columns[3:]
            variables = {}
            for i,col in enumerate(columns):
                value = unicodedata.normalize('NFKD', col.text).encode('ascii', 'ignore')
                variables[headers[i]] = value
            variables["College"] = college
            scraperwiki.sqlite.save(unique_keys=['Name',"Department"], data = variables)