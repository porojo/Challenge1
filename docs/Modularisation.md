| The Modularisation Structure |
|------------------------------|
| <img src="https://github.com/porojo/Challenge1/assets/55001497/ed709eab-da8c-46b6-b7d8-407e9e4b3079" alt="Challenge #1 (The Modularisation Structure)" width="300"> |

| Module    | Module Type         | Dependencies | Purpose                                                                                          |
|-----------|---------------------|--------------|--------------------------------------------------------------------------------------------------|
| :data | android-library | N/A | It is the source of data for the app and contains both public (expose data to the rest of the app) and private (retrieve data and act as single source of truth) repositories... |
| :features | android-library | :data | It is used to present the data to the user as well as receive user input in a stateful manner... |
| :ui | android-library | N/A | It contains the shared UI Elements and Theme to be used by :feature and :app... |
| :app | android-application | :features | It builds and runs the application as well as providing global configurations... |

# The Benefits

- Data flows unidirectionally...
- No module has access to a layer it is not meant to access...
- This modularisation structure easily supports scalability when the need arises...
