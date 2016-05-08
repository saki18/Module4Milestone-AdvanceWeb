# Module4Milestone-AdvanceWeb
CITP290: Module4Milestone. The web application will display the current, open session and closed session.

Milestone Requirements

Choose any TWO* of the following, create them in separate projects, and upload them to separate discussion board threads with the name of topic clearly indicated in the topic.  Note that because we are doubling the number of submissions, please do four milestone peer reviews instead of two.

* You can choose to complete THREE of the following instead.  If you do, and you complete an extra milestone review (5 total), you will receive two bonus points for the course.

    Error Handling
        Create a new Java project.  This does not need to be a web application, but it can be.
        Create a class with one instance method that accepts two ints as parameters and does something simple with them, such as adding them together a returning the result.
        Create two new exception classes: one checked, and one unchecked.  Call the checked exception something innocent like "RandomInterruptionException" and call the unchecked exception something significant like "RandomCatastrophicException".
        Using Math.random() modify your instance method as follows:
            If either int is less than zero or greater than 1000 the method should generate a SEVERE log message and then throw an IllegalArgumentException (this exception is built in to Java, don't create it).
            Generate a random number...
            If the random number is between 0.0 and 0.1 then generate a WARNING log message and throw a RandomCatastrophicException.
            If it's between 0.1 and 0.5 then throw a RandomInterruptionException.
            Otherwise, just allow the method to resolve normally.
        Create a main method (or Servlet/JSP if doing a web app) which allows the user to enter two integers for your new class's instance method.  Do everything you can to prevent IllegalArgumentExceptions.  Catch the RandomInterruptionException when it happens, generate a FINE log message, and retry the user's two numbers without letting the user know.  Do not catch RandomCatastrophicException (allow it to crash your program/page), but make sure the message it displays is useful to the user.

    Security
        Create a new Java project.  This does not need to be a web application, but it can be.
        Create a class with the following instance methods...
            One method which takes a plain-text password (String) and a salt value (String) and uses a secure cryptographic hash function to return the securely hashed password.
            One method that generates a securely random anti-CSRF token (a very large randomized String), stores it in an instance variable, and returns it.
            One method that takes an anti-CSRF token as a parameter and returns a boolean which is true if it matches the instance variable.
            One method that takes a String as a parameter and returns that same String after HTML encoding it.
        Create a main method (or Servlet/JSP if doing a web app) which...
            Simulates a login for a pre-configured username and password, checking if the hash of the password entered by the user matches the hash of the pre-configured password.
            If using a console application...
                Generate and display the anti-forgery token to the user, then ask them to type a sentence followed by the anti-forgery token.  If the anti-forgery token doesn't match, do nothing.  If it does match, return the sentence as HTML encoded.
            If using a web application...
                Display a form page with a single text input asking for a sentence.  The form should also include the anti-forgery token as the value of a hidden input.  When the form is submitted check to make sure that the anti-forgery token matches, and if so display the user's sentence back to them as HTML encoded.

    Advanced Web Features
        Create a new Java Web Application project.
        Create a ServletContextListener which gets the current time as a String and stores it as a servlet context attribute (a.k.a. application scope bean) named something like "servletLoadTime".
        Create a Filter which gets the current time for each request and sets a session attribute (session scoped bean) named something like "sessionOpenTime" as long as it does not already exist.
        Create another Filter which gets the current time for each request and sets it as a request attribute named something like "requestReceivedTime".
        Create a JSP which displays the servlet load time, session open time, and request received time.

    Custom Properties
        Create a new Java Web Application project.
        Create a file called "default.properties" inside of your source package.  Put two properties in this file: "color.background=blue", and "color.text=red".
        Create three more properties files: "messages.properties", "messages_en.properties", and "messages_fr.properties".  The first two files should contain the property "greeting=Hello" and the _fr file should contain "greeting=Bonjour" instead.
        Create a new JSP which...
            Loads default.properties and sets the background-color and color CSS rules on the body element using the appropriate property files.
            Uses "messages" as a resource bundle, displaying the appropriate greeting in both locales (i.e. "Hello, World!" and "Bonjour, World!").
