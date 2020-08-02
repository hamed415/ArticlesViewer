# ArticlesViewer

In this project I have used:
- kotlin, RxKotlin, Coroutine
- Dependency Injection (Koin)
- Unit tests in app and core modules using JUnit
- MVP, MVVM patherns
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

In order to try MVVM and coroutine I have created a second screen to display the articles in vertical layout in recycler view

core module:
>I have the my models in core which will be used by the app. Abstract classes of Uasecaes is also in usecase folder that 
will be used in app. There is also a TimeUtil file that is unit tested.

navigation module:
>This module just contain the abstract classes for MVP pathern

repository module:
>This module uses retrofit and API models (in model package) to call and return json response from http://newsapi.org/ site.
Dependency Injection is used when it was required. 
I have used two functions to get the same end point using Rx and the other by coroutine.

# Memory Management
> I have managed the momory at 2 places
1- Using Recycler view at app level 
2- Using CompositeDisposable to Dipose the RxKotin calls

# Unit Tests
> There are four unit tests in the project. 
1- One unit test is at core module to test the valifity of date format in TimeUtil. I just did this in case the server requires specific date format then the API calls do not break. 
2- App module for the mapper to check the validity of core models when created from ModelAPi.
3- App module for Usecase using mockito
4- App module main presenter using mockito



