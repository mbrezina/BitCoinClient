This web application implements REST client getting actual BitCoin rate from a public REST API: 
https://coinmate.io/api/ticker?currencyPair=BTC_CZK The web application shows the actual BitCoin rate: price of 1 BitCoin in Czech Crowns. The web application includes actual rate, a graph of BitCoin rate in past 7 days and a table with exact prices of BitCoin in past 7 days and price changes.

The backend:
Spring Boot
Repository interface implemented by Spring Data
database - MariaDB
an own API sending data to Javascript

The frontend:
HTML, CSS
graph made with Chart.js, getting data from the own API
