# Synthetic micro-benchmark

The purpose to see the behaviour of different http-servers under high RPS.
For this moment we compare different java based approaches:
- tomcat servlet + apache async http client
- netty approach
- helidon approach with green threads
- go

Within each of the projects put vegeta reports produced on my machine MacBook Pro M2

# Spring MVC

http://localhost:8081/performance-mvc/?delay=100

```
echo "GET http://localhost:8081/performance-mvc?delay=100" | vegeta attack -duration=10s -rate=1000 | vegeta report
```

# Spring Webflux

http://localhost:8082/performance-webflux/?delay=100

```
echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=10s -rate=1000 | vegeta report
```

# Go

http://localhost:8083/performance-go?delay=100

```
echo "GET http://localhost:8083/performance-go?delay=100" | vegeta attack -duration=10s -rate=1000 | vegeta report
```

# Helidon SE

http://localhost:8084/performance-helidon?delay=100

```
echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=10s -rate=1000 | vegeta report
```

Load generator - [vegeta](https://github.com/tsenart/vegeta)

# Scenario 
![telegram-cloud-photo-size-2-5447320972026828987-y](https://github.com/RassulYunussov/performance-api-webflux-vs-mvc-vs-golang/assets/19565394/de079db5-2920-460d-959d-13158f4c615c)
