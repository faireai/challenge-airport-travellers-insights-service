# Airport travellers insights service

*Sample Spring Boot/Java service that gives insights on airport travellers.*

*Airport travellers insights service* is a REST service that provides insights
on flights and airports.

In this code challenge, we want to implement a feature that gives **insights on
the purpose of trips** travellers do.
We can take advance of [Amadeus APIs](https://developers.amadeus.com/) and use
[Trip Purpose Prediction](https://developers.amadeus.com/self-service/category/trip/api-doc/trip-purpose-prediction/api-reference)
to predict if the purpose of a round trip travel is for leisure or for business
with a certain probability.
With such information the service has to provide an operation that, given an
airport and a date, returns the number of passengers that are travelling in that
date for leisure and for business.

## Service capabilities

The service has to provide the following operation. 

### Register a trip

Register a round trip travel from a departure airport to a destination airport
with the dates of flight departures from both airports. 

### Cancel a trip

Cancel a registered flight.

### Get airport insights

Given an airport and a date, return the number of traveller that transit on the
airport in that date, the number of travellers that have a trip for leisure, the
number of travellers that have a trip for business.

## Assignment

The following activities must be accomplished in the code challenge to fully
implement the feature described above.
You can start from the sources that this project already contains to speed up
the implementation.

**Note.** During the implementation you can change any file of this project.
What we provide is a service scaffold with the purpose of the simplifying the
development of the service.
If something can be enhanced, any valuable improvement will be appreciated.
If something has to be changed because it is wrong and/or it does not fit the
solution you are implementing, then change it and document your modifications if
that may help in understanding your decision.

- [ ] Complete the documentation of the API updating the OpenAPI we provide by
      designing the missing parts.
- [ ] Implement the service operations as described in section
      [Service capabilities](#service-capabilities).
- [ ] Implement tests to verify that correctness of the service functionalities.
- [ ] Add instructions to build a [Docker](https://www.docker.com/) container
      image containing the service and explain how to launch it.
      Document it in section [Run with Docker](#run-with-docker) within this
      page.
- [ ] Fill the *TODOs* in this README file.
- [ ] Upload the code to a public repository or a private one after granting the
      access to [gilberto@faire.ai](mailto:gilberto@faire.ai) (Head of
      Technology @ *faireai*) that may request the access for other colleagues
      for the review.

### What we evaluate

During the evaluation of your implementation we pay attention to the following
points.

- Correctness of the business logic.
- Quality of the code with a focus on its readability.
- Architecture of the service.
- Proper tests code coverage and use of tests.

TODO Implementation must be pushed to a public repository or to a private one
that must guarantee the access to some specific developers at *faireai*.

## Build

The project uses [Gradle](https://gradle.org/) as build tool.
It makes easy to build the service and launch it.

To compile and verify the project run:

```shell
% ./gradlew clean check
```

## Configuration

*TODO Document how to configure the service.*

## Run the service

The service can be launched running the following command:

```shell
% ./gradlew bootRun
```

### Run with Docker

*TODO Document how to run the service using Docker.*

## Usage

*TODO Explain how to use the service and provide examples.*

## Notes

- If you are using GitHub as CVS you can take advantage of GitHub Actions.
  The project contains configured workflows in `.github` directory. 
