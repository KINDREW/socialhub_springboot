# SocialHub

SocialHub is a simple social media platform backend built with Spring Boot, where users can register, login, create posts, and interact with other users.

## Technologies Used

- **Spring Boot**: Backend framework for building RESTful APIs.
- **Spring Data JPA**: Provides repository support for easy interaction with the database.
- **MySQL**: Relational database for storing user information and posts.
- **Spring Security**: Provides authentication and authorization mechanisms.
- **DTOs (Data Transfer Objects)**: Used to transfer data between client and server.
- **RESTful API**: All endpoints follow REST principles for communication.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine
- MySQL database installed and running locally

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/KINDREW/socialhub_springboot.git
   ```

2. Set up MySQL database:

   - Create a new database named `socialhub`.
   - Update the `application.properties` file with your MySQL database configuration.

3. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. The application will start at http://localhost:8080.

## API Endpoints

### Users

- `POST /users/register`: Register a new user.
- `POST /users/login`: Login with username/email and password.

### Posts

- `GET /posts/{userId}`: Get posts by user ID.
- `POST /posts`: Create a new post.
- `POST /posts/{postId}/like`: Like a post.
- `POST /posts/{postId}/comment`: Comment on a post.
- `GET /posts/{postId}/likes`: Get all likes for a post.
- `GET /posts/{postId}/comments`: Get all comments for a post.

## Contributing

Contributions are welcome! Please feel free to open an issue or submit a pull request for any improvements or additional features.
