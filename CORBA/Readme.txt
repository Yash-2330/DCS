Step 1 : create the idl file with the the function that needs to be implemented, idl file here can be opened with notepad
step 2 : compile the idl file using command : "idlj -fall -oldImplBase Tempconvcal.idl"
step 3 : the above command generates the client side and server side code in the foler named : "Tempconvcalc"

step 4 : open eclipse and create a new java project named CorbaServerSide
step 5 : create 2 new packages : main and Tempconvclac
step 6 : copy the files "_TempcalcImplBase.java", "Tempcalc.java" and "TempcalcOperations.java" from the "Tempconvcalc" folder that we generated using the idlj command to the package "Tempconvcal" that we just created 
step 7 : copy "Tempcalcimpl.java" to main package
step 8 : Create a new class "TempConvServer" in main package

step 9 : open eclipse and create a new java project named CorbaClientSide
step 10 : create 2 new packages : main and Tempconvcalc
step 11 : copy the files "Tempcalc.java", "TempcalcOperations.java", "TempcalcHelper.java", "TempcalcHolder.java" and "_TempcalcStub.java" from the "Tempconvcalc" folder that we generated using the idlj command to the package "Tempconvcal" that we just created
step 12 : create new class "TempConvClient" in main package

step 13 : go back to the main directory of the CORBA folder 
step 14 : run the command : "start orbd -ORBInitialPort 1050 "

step 15 : open eclipse and click on run as configuratioin for "TempConvServer" 
step 16 : in the Arguments tab add the two lines:
	  -ORBInitialPort 1050
          -ORBInitialHost Localhost
step 17 : Run the TempConvServer

step 17 : open eclipse and click on run as configuratioin for "TempConvClient"
step 18 : in the Arguments tab add the two lines:
	  -ORBInitialPort 1050
          -ORBInitialHost Localhost
step 19 : Run the TempConvClient