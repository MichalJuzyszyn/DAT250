## No technical issues during installation of MongoDB.
## Validation of installation package:
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/ssha-check.PNG)

## Results obtained during experiment 1:

### Insert
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/insert.PNG)

### Queries
#### Select documents where the "status" equals "A" and either qty is less than30 or i tem starts with the character p.
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/query.PNG)

#### Select documents where the dim_cm array contains at least one element that is both greater than ($gt) 22 and less than 30.
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/query2.PNG)

#### Select documents where the instock array has at least one embedded document that contains the field qty that is greater than 10 and less than or equal to 20.
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/query3.PNG)


### Update
#### Using updateMany()
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/update1.PNG)
#### Using replaceOne()
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/queryreplace.PNG)

### Delete
#### Using deleteMany()
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/delete.PNG)

## Map-Reduce results during experiment 2:
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/mrexample1.PNG)
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/mrexample2.PNG)
### Additional map-reduce:
![Image of validation](https://github.com/MichalJuzyszyn/DAT250/blob/main/experiments/screenshots/mapreduce3.PNG)

#### The additional map-reduce function gathers all of the items, their quantities bought and prices and finally counts the average price of each of the item. This shows us which product is the cheapest on average per piece.
