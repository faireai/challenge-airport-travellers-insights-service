# Airport travellers insights service

*Sample Spring Boot/Java service that gives insights on airport travellers.*

*Airport travellers insights service* is a REST service that gives insights on
flights and airports.

In this code challenge, we want to implement a feature that gives **insights on
the purpose of trips** travellers do.
We can take advantage of [Amadeus APIs](https://developers.amadeus.com/) and use
[Trip Purpose Prediction](https://developers.amadeus.com/self-service/category/trip/api-doc/trip-purpose-prediction/api-reference)
to predict if the purpose of a round trip travel is for leisure or for business
with a certain probability.
With such information the service has to provide an operation that, given an
airport and a date, returns the number of passengers that are travelling for
leisure and for business in that date.

## Service capabilities

The service has to provide the following operations.

### Register a trip

Register a round trip travel from an origin airport to a destination airport
with the departure and return dates of the flights.

### Cancel a trip

Cancel a registered trip.

### Get airport insights

Given an airport and a date, return the number of traveller that transit through
the airport in that date, the number of travellers that are travelling for
leisure and for business and the probabilities that the estimations are correct.

As an example, let assume that we have registered two trips:

1. **Passenger 1**, travelling for leisure, from LIN to AMS with departure date
   2022-07-14 and return date 2022-07-18, and
2. **Passenger 2**, travelling for business, from BRU to LIN with departure date
   2022-07-12 and return date 2022-07-14.

Requesting the insights of Linate (LIN) airport on 2022-07-14 must return that
there are 2 passengers in the airport: one is travelling for leisure and one is
travelling for business.

## Assignment

The following activities must be accomplished in the code challenge to fully
implement the feature described above.
You can clone this repository and start working from the sources provided by
this project.
You can change any file of this project: the existing code consists of a service
scaffold with the purpose of simplifying the development of the service.

- If something can be enhanced, any valuable improvement will be appreciated.
- If something has to be changed because it is wrong and/or it does not fit the
  solution you are implementing, then change it and document your modifications
  if you think the change is not clear to understand.

The activities to be accomplished are listed herein.

- [ ] Complete the documentation of the API updating the OpenAPI we provide by
      designing the missing parts.
- [ ] Implement the service operations as described in section
      [Service capabilities](#service-capabilities).
- [ ] Implement tests to verify that correctness of the service functionalities
      and prevent regressions on further changes.
- [ ] Add instructions to build a [Docker](https://www.docker.com/) container
      image containing the service and explain how to launch it.
      Document it in section [Run with Docker](#run-with-docker) in this page.
- [ ] Fill the *:pencil2: TODOs* in this README file.
- [ ] Upload the code to a public repository or a private one after granting the
      access to [gilberto@faire.ai](mailto:gilberto@faire.ai) (Head of
      Technology @ *faireai*); we may request to grant access to other
      colleagues that will review the code.

### What we evaluate

During the review of your implementation we pay attention to the following
points.

- Correctness of the business logic.
- Quality of the code with a focus on its readability.
- Architecture of the service.
- Proper tests code coverage and use of tests.

## Build

The project uses [Gradle](https://gradle.org/) as build tool.
It makes easy to build the service and launch it.

To compile and verify the project run:

```shell
% ./gradlew clean check
```

## Configuration

*:pencil2: TODO Document how to configure the service.*

## Run the service

The service can be launched running the following command:

```shell
% ./gradlew bootRun
```

### Run with Docker

*:pencil2: TODO Document how to run the service using Docker.*

## Usage

*:pencil2: TODO Explain how to use the service and provide examples.*

The service exposes the endpoint `/api-docs` to get the OpenAPI documentation
of the service API.
On localhost, you can get it with `curl` with the following command.

```shell
% curl localhost:8080/api-docs
```

## Notes

- If you are using GitHub you can take advantage of GitHub Actions.
  The project contains configured workflows in `.github` directory. 
