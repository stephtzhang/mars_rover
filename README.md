# space_rover
Java implementation of a space rover that accepts text input and navigates on a plane.

### How to Run

Type the following from the command line in the mars_rover dir:
    make java Runner // this runs the default input file

To run other input files, add them to the input_files folder and type:
    java Runner FILE_NAME

To run tests:
    javac -cp .:junit-4.12.jar tests/TEST_NAME.java
    java  -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.TEST_NAME

