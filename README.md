# ArticlesViewer

In this project I have used:
- kotlin, RxKotlin
- Dependency Injection (Koin)
- Unit tests in app and core modules using JUnit
- MVP pathern
- Retrofit

this project has 4 Modules:
- app 
- core
- navigation
- repository 

app module:
> App is using all other three modules. Responsible for User interactions. MVP pattern used for view, business logig
and model. For layouts I have used ConstraintLayout and RecyclerView to display the articles in horizontal way.
Picasso is used to load the images and clicking on each item opens the corresponding article url in a new browser.
I have also added usecases that is used by interactor and it uses the dependency injection from repository for API calls. 
The interactor is used by presenter. I have one unit test which tests the mapper. 
This mapper is responsible to convert the API_Models from retrofit to CORE_MODELS in core module used by app.

core module:
>I have the my models in core which will be used by the app. Abstract classes of Uasecaes is also in usecase folder that 
will be used in app. There is also a TimeUtil file that is unit tested.

navigation module:
>This module just contain the abstract classes for MVP pathern

repository module:
>This module uses retrofit and API models (in model package) to call and return json response from http://newsapi.org/ site.
Dependency Injection is used when it was required

# Unit Tests
> There are only 2 unit tests. One at core to test the valifity of date format. I just did this in case the server requires specific date format then the API calls do not break. The second unit test is at app level for the mapper to check is the ModelAPi is mapped correctly to the core models.

# Improvements to be done
> We should manage the text on title and description to remove html or special charactes. Those texts should also be managed so it is not chopped at the end of the line. I see that the first image does not load as it should.

# Challenges
> The json file returned had nulls in some parameters which was causing the app to crash. solution: The ApiModels accepts null value and the mapper on app side handles it
The retrofit was not working properly. Solution: the wrong API model was used and replaced with right one. Today the API stoped sending data which was because of the date mentioned (for free license it show the history up to 1 or 2 weeks), so I had to cread a LocalDateTime to pass in query.


