Feature: Test seller login

	Scenario Outline: Login scenario test for seller
		Given navigate to seller login page
		When seller logged in using userid as "<userid>" and password as "<pwd>"
		Then Welcome To Seller Login Page should be displayed
	
	Examples:
		|userid			        |pwd					|
		|admin				      |admin			|
	 #|Mark			|Mark_321		|
	 #|Carl			|Buzz$55		|