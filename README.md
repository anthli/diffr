# diffr-server
![Jenkins Build Status](https://img.shields.io/jenkins/build?jobUrl=http%3A%2F%2Fpi.anthli.com%3A8080%2Fjob%2Fdiffr-server%2Fjob%2Fmaster%2F)
![Jenkins Test Status](https://img.shields.io/jenkins/tests?compact_message&jobUrl=http%3A%2F%2Fpi.anthli.com%3A8080%2Fjob%2Fdiffr-server%2Fjob%2Fmaster%2F)

Just another diff tool. This is the server component of the app. The client
component can be found [here](https://github.com/anthli/diffr-client).

diffr is a web application to help visualize the diff between two bodies of
text.

### Introduction
Many have used (or will use) a diff tool at some point in their life as
a developer. However, not everyone asks themselves "how does it really work?".

This project started from wanting to learn what really happens behind the scenes
when running the command `git diff`. While not intended to be a clone, this
project serves as a learning experience into what constructs a diff.
