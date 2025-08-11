# Kotlin People API

This API was created entirely with OpenAI Codex. It manages an in-memory list of people.

## What it does

- **POST /people** — accepts a JSON object with the fields `name`, `age`, and `gender`, adding it to the list.
- **GET /people** — returns the current list of people as JSON.

## Example usage

To add people

```bash
curl --location --request POST 'localhost:8080/people' \
--header 'Content-Type: application/json' \
--data '{
    "name": "John Doe",
    "age": 25,
    "gender": "men"
}'
```

To get all people

```bash
curl --location --request GET 'localhost:8080/people'
```

## Technologies used

- [Kotlin](https://kotlinlang.org/)
- [Ktor](https://ktor.io/)
- [Gradle](https://gradle.org/)
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)

## Original prompt

Create an API using Kotlin in this repository that is empty. You are free to choose the framework.
The API must have an object with the fields: Name, Age and Gender. It must expose a POST route
that receives a JSON object and adds it to the list. It must expose a GET route that returns this list in JSON.
In the end the README.md must be edited explaining that this API was created totally with OpenAI Codex,
explaining what it does, which technologies were used and finally attach this prompt.
