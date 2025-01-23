# To-Do App (Android)

This is a simple To-Do list application built for Android using the Kotlin programming language. The app allows users to manage tasks, set priorities, and track completion.

## Features:
- Add, update, and delete tasks.
- Set task priorities (Low, Medium, High).
- Mark tasks as completed.
- Save tasks locally using Room Database.

## API:
This app does not rely on an external API. It stores tasks locally using Room Database to persist data across app launches.

## Dependencies:

| **Name**           | **Description**                                                                                                                                                 |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **LiveData**        | LiveData is an observable data holder class that allows us to monitor changes in data. LiveData is lifecycle-aware and helps ensure that data updates are only made when the UI is in a valid state. |
| **Room**            | Room provides an abstraction layer over SQLite, allowing you to interact with a local database seamlessly. It simplifies database operations while ensuring full access to SQLite. |
| **View Binding**    | View Binding allows you to interact with views in a more efficient and type-safe manner. It eliminates the need for `findViewById()` calls and helps avoid null pointer exceptions. |
| **MVVM**            | MVVM (Model-View-ViewModel) is the architectural pattern used in this app: <br> - **Model**: Contains the data of the application. <br> - **View**: Represents the UI elements of the application. <br> - **ViewModel**: Mediates between the Model and the View. |
| **Data Binding**    | Data Binding allows you to bind UI components in layouts to data sources declaratively, rather than writing code to update views manually.                         |
| **Jetpack**         | Jetpack is a suite of libraries, tools, and architectural guidance that simplifies app development. It includes libraries like Room, Paging, and Data Binding. |
| **Glide**           | Glide is an image loading and caching framework for Android, though not extensively used in this app, it can be utilized for displaying images (e.g., user profile images). |


