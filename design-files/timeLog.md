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
