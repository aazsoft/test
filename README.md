# Solution Architect Test Project sample
This is a test project Sample to convert a source temperature to a target temperature

Usage: You can convert the temperature by using following code:

	 // convert from Celsius temperature degree to Fahrenheit temperature
    double fahrenResult = new TemperatureConversion().convert(0, "C").to("F").execute();
    // convert from Kelvin temperature degree to Celsius temperature
    double celsiusResult = new TemperatureConversion().convert(273.15, "K").to("C").execute();
    // convert from Fahrenheit temperature degree to Kelvin temperature
    double kelvinResult = new TemperatureConversion().convert(32, "F").to("K").execute();

You will got error when use invalid input for conversion or not supported conversion method


	 // invalid conversion
    // not supported source or target temperature unit
    new TemperatureConversion().convert(fahrenheit, "U").to(F_UNIT).execute();
    new TemperatureConversion().to("U").execute();
    // no source to convert
    new TemperatureConversion().to(F_UNIT).execute();
    // no target temperature unit to convert
    new TemperatureConversion().convert(fahrenheit, F_UNIT).execute();
    // no input for source temperature unit
    new TemperatureConversion().convert(fahrenheit, null).to(F_UNIT).execute();
    // not supported convert method from K to F
    new TemperatureConversion().convert(kelvin, K_UNIT).to(F_UNIT).execute();

See more details at **TemperatureConversion.java**     
    

# Implementation

**Factory Method pattern** : ConversionServiceFactory class

This class is to create a right service implementation for the input conversion method. If the user wants to convert the temperature from Celsius to Fahrenheit temperature, then the implementation for this conversion (e.g. **C2FConversionServiceImpl.java** ) will be created.

The multiple service implementations for the same converter interface (e.g. **ITemperatureConverter** ) will help us to separate the business implementation into appropriate class and increase the maintainability. This way also helps us to easily extend the implementation whenever having new conversion method added.

**Fluent Interface pattern** : TemperatureConversion and ConversionContext classes

The implementation of the Fluent Interface pattern can be seen in both **TemperatureConversion**  and **ConversionContext**  classes. To my opinion, this pattern is similar to Builder pattern which is used to build target object depends on different parameters.

**Exception handling** class
The hierarchy of exception classes was created using inheritance in Java to implement this. Since it is recommended to use exception class to handle exception in Java program and avoid to use error code constants to handle it. This way we can create a very concrete sub-class which names the exact business exception case.

We have the root exception class named **ConversionException** which extends the root **Exception**  class


	InvalidSourceInputException extends ConversionException {
	   // do implementation
	}
	
	InvalidTargetInputException extends ConversionException {
	   // do implementation
	}

The explicit separation of sub-exception classes will enable us to handle the business case for every exception. For instance, if you input the wrong input to convert, then the **InvalidSourceInputException**  object will be thrown with its own error message.

**Floating point handling** : MathUtils.java
The program uses the BigDecimal class in Java to handle the floating point calculation. This is recommended since BigDecimal class has many powerful methods to deal with floating point number.

# Unit test

Currently, i just give one example about unit test for **MathUtils**  class. This class contains the method for rounding the temperature value into a 2 decimal places.


# References

1.  Fluent Interface pattern: https://en.wikipedia.org/wiki/Fluent_interface
2.  Java 8, Spring Boot 1.5.9.RELEASE, JUnit 4.12, Maven 4.x.x

# Author
This sample was created by Quoc Truong LE, Technical Architect at BBV.CH (Vietnam office in Ho Chi Minh city)
Please email & call for details if you have any questions.

Many thanks.

      