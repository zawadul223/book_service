# Book Manager

This book manager project is a spring boot project which provides the facility to store books in a structured way.



## Features

- Store book details like book name, author name
- Based on the role, user can either see or edit the list
- To provide security, JWT token is provided which expires after the session
- Encrypted password protection
- Login, register system

## Technologies

- Spring Boot 3
- Spring Security
- JSON Web Token (JWT)
- Gradle

## Endpoints

In this part we will see the endpoint urls and some sample request and response.
<br>

<strong>/user/register<strong>

```
{
    "firstName" : "Zawadul12",
    "lastName" : "Islam12",
    "userName" : "zawadul245",
    "password" : "123356",
    "role" : "CUSTOMER",
    "email" : "zawad12@gmail.com"
}
```

<br>

<strong>/user/login</strong>

```
{
    "email" : "zawad@gmail.com",
    "password" : "12334"
}
```
<br>

<strong></strong>
```

```

<br>
<strong>/books/all</strong>

```
    {
        "id": 1,
        "bookName": "Game of Thrones 2",
        "author": "George R. S. Martin"
    },
    {
        "id": 5,
        "bookName": "Football",
        "author": "Leonel Messi"
    },
    {
        "id": 6,
        "bookName": "Jhingephul",
        "author": "Kazi Nazrul Islam"
    },
    {
        "id": 7,
        "bookName": "Man vs Wild 2",
        "author": "Bear Grylls"
    }
```

