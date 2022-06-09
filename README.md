# Code Fellowship Labs

## Labs 15, 16 and 17

Create webapp called CodeFellowship that allows people learning to code to connect with each other and support each other on their coding journeys.

## How To Use This App

1. Have a modern web browser like Google Chrome (Firefox or Edge)
2. Install Java (recommend installing JDK 17+)
3. Install PostgresQL (a latest, stable, supported version will do) and create a database.
4. Install Gradle v.7.4.2
5. Clone this repo.
6. Update application.properties with information listed in [Application Properties section](#application-properties)
7. At the terminal in the repo root folder, execute: `gradle bootRun`
8. Gradle will install dependencies listed in application properties.
9. Launch a browser and point the URL bar to 'localhost:8080'
10. You will need to register yourself as a user using a 'Register' link.
11. Once registered, you can login, visit the profile page (slash route), or logout.

## Application Properties

File Application.Properties is not included in this repo for various reasons.

You will need to create one and put it in the './resources/templates' directory before building or running this webapp successfully.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_postgres_admin_username
spring.datasource.password=your_postgres_admin_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
```

## Feature Tasks

- [X] build a webapp that allows users to log into CodeFellowship
- [X] single login page
- [X] login page has link to signup page
- [X] ApplicationUser has username, password (hashed), firstName, lastName, dateOfBirth, and bio
- [X] ApplicationUser fields can all be configured via the signup page
- [X] User can create an ApplicationUser on the signup page
- [X] Controller is 'Autowired' to manage password encoding
- [X] Follow steps using the [Spring Security Cheat Sheet](https://codefellows.github.io/code-401-java-guide/curriculum/SpringSecurityCheatSheet.html)
- [ ] Site should have a homepage as "slash route" aka "/" that contains basic information about the site
- [ ] Slash route should have links to login and signup
- [ ] Slash route should have link to logout if user is already logged in
- [ ] User is redirected to home/login page when they logout
- [ ] When user is logged in the app should display the username on every page
- [ ] Ensure homepage, login, and registration routes are accessible to non-logged-in users
- [ ] Site should be well styled and attractive
- [ ] Site should use templates to display information
- [ ] Ensure user registration also logs users into your app automatically

## Kudos and Credits

Ben Mills
Alex White
Roger Reyes

...for their assistance in helping me resolve various bugs along the way!