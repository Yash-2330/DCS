step 1 : create java project, create package, add class 
step 2 : right click on java project name, click on build path 
        -> from there add external jars 
        -> navigate to mpj_express folder and add mpj.jar file
step 3 : add code to the class 
step 4 : to run the code 
        4.1 
        -> click on the run button in green above
        -> click on the run configurations 
        -> click on Environment tab 
        -> create new vairable if not created and add MPJ_HOME which points to the mpj root folder 
        -> apply 

        4.2
        -> click on the arguments tab
        -> go to VM Arguemnts section 
        -> type the command " -jar ${MPIHOME}/lib/starter.jar " , note: "MPIHOME" is the same name that we selected in the Environment tab
        -> click on apply 
        -> Now run the code


Download MPJ from : https://sourceforge.net/projects/mpjexpress/

See this link to understand the above steps properly : https://www.youtube.com/watch?v=ROXFfUbgY98