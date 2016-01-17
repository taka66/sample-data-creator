# sample-data-creator
This api create sample data for creating sample application.
Sample data re-create randomly every time.
Currently this application support only following data pattern.

## Condominium
Condominium data pattern has 2 types of data set.

![Condominium Data Model](http://takahirofujii.com/product/sample-data-creator/0.0.1/condominium-data-model.jpg)

###Usage
1.Download jar file from [here](https://github.com/taka66/sample-data-creator/tree/master/target). And start-up jar file like following.

```
java -jar ./target/sample-data-creator-0.0.1.jar
```

2.Or check out this repository and run it as a Spring Boot App.

###Data structure
| Data pattern | URL sample | Description |
|:-------------|:------------|:------------|
| master data  | http://localhost:9991/condominium/get?field=master&size=5 | Condominium has master data which stored id,name,prefecture. |
| sales data   | http://localhost:9991/condominium/get?field=sales&size=5 | Condominium has sales data of recent 1 year. |

![SampleResponse](http://takahirofujii.com/product/sample-data-creator/0.0.1/response-sample.jpg)

You can confirm detail api documentation(html) at /target/generated-docs/api-guide.html  
And also latest html is uploaded at [my web site](http://takahirofujii.com/product/sample-data-creator/0.0.1/api-guide.html) .