# AutoMobileTask
Test execution for todoit app mobile as required:
1. Test “Create Project”
    1. Create test project via API.
    2. Login into mobile application.
    3. Verify on mobile that project is created
2. Test “Create Task via mobile phone”
    1. Create test task via mobile application in test project.
    2. API: Verify that task created correctly.
3. Test “Reopen Task”
    1. Open mobile application
    2. Open test project
    3. Created test task
    4. Complete test task.
    5. Reopen test task via API.
    6. Mobile: Verify that test task appears in your test project
How to use the project: 
1. Install and using Intellij, JDK, APPIUM(1.19.1) and LDPlayer 
2. Clone Project from my GitHub to your device. Then open Intellij, Click File -> select Open -> select Project you cloned
3. In the left of the screen, Click src -> main -> java -> test. Then right click TestAll and click on Run "TestAll".

