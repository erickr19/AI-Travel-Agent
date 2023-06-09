# Time log for AI-Travel-Agent
### Daily development logs/journal
#### 4/10
Started experimenting with OpenAI's API to see what I could make. Came up with the idea to make a
web application where a user can query the AI to create travel plans. I then began designing the front
end for the project. I've though of how to incorporate CRUD functionality into the project, and I've come up
with the following:
###### Create

- User can create an itinerary using AI API call
- User has the option to regenerate the itinerary or save it to profile

###### Read

- User can read their saved itineraries from the database

###### Update

- User can update their itinerary and write their own information that the AI couldn't account for:
- Budget
- Time
- Etc.

###### Delete

- User can delete their itineraries if they change their mind of the trip

#### 4/12
I set up the project foundations such as the pom.xml with dependencies. Added needed directories to display a basic front end.
I started to work on the front end and got a good portion of it done!

#### 4/13
Finished up most of the front end code. There are some pages that I need to fix and refactor once I get a user creation/authentication service going.
I designed and created the database for the project using Vertabelo. I got to work on the ORM portion of the project and got the entities setup and mapped.
I added the needed testing utils such as database, properties loader, hibernate.cfg.xml, etc.
I got the first test for ItineraryDao to pass which was the insert test. I will continue work tomorrow!

#### 4/14
Wrapped up tests for dao classes! Once I got this done, I started working on the controller classes for the project.
This went hand in hand with creating new jsps for the controllers that required one. I implemented the DAOs in ViewItinerary and UserProfile.
When I got all non-API dependent controllers done is when I got started on connectivity to the OpenAI API.
It took some researching, documentation reading, and time, but I managed to start getting responses from the API!
I'm so proud of myself for getting this accomplished and in no time at all! It goes to show how far I've come as a web software developer.

#### 4/15
This day I've simplified the I/O of the API access. I mean that I added POJOs can be fed into the request and used to read the response.
I've also integrated the AI functionality into the actual web application instead of it being a test.
Today I've also added all CRUD operations. Creating the itinerary and saving it to the database. Reading the database for all the itineraries.
Updating/editing itineraries and, finally, deleting itineraries. I would say that the project is about 70% complete. I just need to add AWS Cognito for User
creation and authentication. Then refactoring the controllers to account for this change in user handling. The last step would be to add the project to the cloud.

#### 4/16
I've added AWS features to my project. I started by deploying my project onto AWS Elastic Beanstalk. After making sure that was working, I added AWS Cognito to my project.
I then created logic classes to check if the signed-in user exists in the database. If they do, it loads the existing user into the session. Otherwise, it creates a new user into the database.
I started making changes to the frontend to test getting user data from the session rather than it's hardcoded request attribute.

#### 4/17
I've started making changes to other classes and frontend to work with the new code of the previous day. I modified the classes that relied on a hardcoded User object, so it dynamically retrieves the user from the session when logged in. 
Additionally, I made frontend changes so that it compensates for the addition of dynamically added users. I had to make slight modifications and fixes as my webapp was encountering a bug whenever I wanted to edit the itineraries.
I also had to fix a bug that didn't remove/update the user's itineraries list. I found out that the issue had to do with the user in the session not updating the changes but the user in the database was.
I had to add a new method in UserProfile to update the user everytime the user visits the Servlet by fetching the user in the database again.

#### 4/18
Today was a light day as I just added an almost finalized dump.sql file. I also allowed the AI request to use more tokens as I found out that it sometimes shorts the user out on a complete itinerary.

#### 4/26
I had to take a break from my project as I had to complete work for Enterprise Java, but I'm back to finalize my project! Today I've finished most of the QAPlug code suggestions and refreshed my GitHub repo to remove the .idea
directory.