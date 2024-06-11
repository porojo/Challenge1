# The Modularisation Structure
- Challenge #1 has been modularised based on the following structure:

  <div style="text-align: center;">
  <img src="https://github.com/porojo/Challenge1/assets/55001497/98b4cb63-6a10-49ac-b62f-d06a68fedfcc" alt="Description of the image">
</div>

- Each of the modules plays the following roles to ensure the goals of Modularisation are met:

| Module | Module Type | Dependencies | Purpose |
|--------|------|--------------|--------|
| :data  | android-library | N/A | It is the source of data for the app... |
| :domain | android-library | :data | It aggregates data from the data source... |
| :features | android-library | :domain | It is used to present the data to the user as well as receive user input in a stateful manner... |
| :app | android-application | :features | It builds and runs the application as well as providing global configurations... |
