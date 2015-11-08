# space_rover
Java implementation of a space rover that accepts text input and navigates on a plane.

### How to Run

Type the following from the command line in the mars_rover dir:
  make
  java Runner // this runs the default input file

To run other input files, add them to the input_files folder and type:
  java Runner FILE_NAME

To run tests:
  javac -cp .:junit-4.12.jar tests/TEST_NAME.java
  java  -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.TEST_NAME

### Design Decisions

I wanted to make my code as object-oriented and test driven as possible. I also focused on handling errors gracefully. I kept my Runner class light, calling on an instance of the Parser class to create a fully functioning mission instance from the text input. The parser class will print an error message and terminate if the input file can't be found, the input file is blank, or the input file has poorly formatted plateau input. In the case where rover input is poorly formatted, that rover is discarded and the rest of the rovers are processed. The Mission class contains a plateau instance, as well as an array list of rover instances. The mission is responsible for broadcasting position updates to the rovers and ensuring that the rovers stay within the bounds of the plateau. In the case when a rover oversteps the plateau bounds, the mission will return -1, -1 as its final position.
