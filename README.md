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
spring.mvc.hiddenmethod.filter.enabled=true
server.error.whitelabel.enabled=false
```
*Note*: This application.properties template code has been updated to the requirements in [Wednesday](#wednesday)'s project work.

## Feature Tasks

### Wednesday

- [ ] Allow users to log in to CodeFellowship, view user profiles, and create posts.
- [ ] Upon logging in, users should be taken to a /myprofile route that displays their information.
- [X] This should include a default profile picture, which is the same for every user, and their basic information from ApplicationUser.
- [ ] The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
- [X] This should include a default profile picture, which is the same for every user, and their basic information.
- [ ] Continue to ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
- [X] Add a Post entity to your app.
- [X] A Post has a body and a createdAt timestamp.
- [ ] A logged-in user should be able to create a Post, and a post should belong to the user that created it.
      Hint: This is a relationship between two pieces of data

- [ ] A user’s posts should be visible on their profile page.
- [ ] The site should use reusable templates for its information. (At a minimum, it should have one Thymeleaf fragment that is used on multiple pages.)
- [ ] The site should have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong.

### Tuesday

- [X] build a webapp that allows users to log into CodeFellowship
- [X] single login page
- [X] login page has link to signup page
- [X] ApplicationUser has username, password (hashed), firstName, lastName, dateOfBirth, and bio
- [X] ApplicationUser fields can all be configured via the signup page
- [X] User can create an ApplicationUser on the signup page
- [X] Controller is 'Autowired' to manage password encoding
- [X] Follow steps using the [Spring Security Cheat Sheet](https://codefellows.github.io/code-401-java-guide/curriculum/SpringSecurityCheatSheet.html)
- [X] Site should have a homepage as "slash route" aka "/" that contains basic information about the site
- [X] Slash route should have links to login and signup
- [X] Slash route should have link to logout if user is already logged in
- [X] User is redirected to home/login page when they logout
- [X] When user is logged in the app should display the username on every page
- [X] Ensure homepage, login, and registration routes are accessible to non-logged-in users
- [X] Site should be well styled and attractive
- [X] Site should use templates to display information
- [X] Ensure user registration also logs users into your app automatically

## Kudos and Credits

Ben Mills
Alex White
Roger Reyes

...for their assistance in helping me resolve various bugs along the way!