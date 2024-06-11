# The Modularisation Structure
- Challenge #1 has been modularised based on the following structure:

  <div style="text-align: center;">
  <img src="https://github.com/porojo/Challenge1/assets/55001497/98b4cb63-6a10-49ac-b62f-d06a68fedfcc" alt="Description of the image">
</div>

- Each of the modules plays the following roles to ensure the goals of Modularisation are met:

| Module | Type | Dependencies | Purpose|
|--------|------|--------------|--------|
| :data  | android-library | N/A | It provides data from different sources... |
| :domain | android-library | :data | It aggregates data from the data sources... |
| :features | android-library | :domain | It consists of the Screens, UI Components, and ViewModels and is used to present the data to the user as well as receive user input... |
| :app | android-application | :features | It builds, runs the application, and contains the Application class and MainActivity... |