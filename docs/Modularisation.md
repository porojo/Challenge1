| The Modularisation Structure                                                                                                                                        |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/porojo/Challenge1/assets/55001497/aacd4576-c705-416e-9a27-7b2f138dc5a6" alt="Challenge #1 (The Modularisation Structure)" width="300"> |

| Module   | Module Type         | Dependencies | Purpose                                                                                                                                                  |
|----------|---------------------|--------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| :source  | android-library     | N/A          | It acts as the source of data by providing and implementing both the Remote and Local Data Sources...                                                    |
| :data    | android-library     | :source      | It abstracts the Data Sources and their implementation from :feature by providing and implementing Repositories which have access to the Data Sources... |
| :feature | android-library     | :data        | It is used to present the data to the user (Screens) as well as respond to user input in a stateful manner (ViewModels)...                               |
| :ui      | android-library     | N/A          | It contains the Shared UI Elements and Theme to be used by :feature and :app...                                                                          |
| :app     | android-application | :features    | It builds and runs the application (MainActivity) as well as providing global configurations (Application)...                                            |

# The Benefits

- Data flows unidirectionally...
- No module has access to a layer it is not meant to access...
- This modularisation structure easily supports scalability when the need arises...
