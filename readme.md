https://docs.spring.io/spring-ai/reference/api/image/openai-image.html

# OpenAI Client with Spring Boot

This project is a simple Spring Boot application that demonstrates the use of [Spring AI](https://docs.spring.io/spring-ai/reference/) to interact with **OpenAI** models for:

- Text generation (ChatGPT with gpt-4o-mini)
- Image generation (DALL·E) (only possible with a paid subscription)

It accepts a JSON request with prompt and return type (`TEXT` or `IMAGE`), then responds with the appropriate AI-generated result.  

Each request is independent of others, so a conversation is not possible.  It could be simulated however, by passing context in each request (i.e.:  including the previous messages from both from the user and from the assistant).

---

## Features

- REST endpoint: `/api/v1/prompt`
- Returns a `TextPromptResponseDTO` or `ImagePromptResponseDTO` based on input
- Integrated with OpenAI via Spring AI
- Input validation with proper error handling
- Designed for quick demos and easy extensibility

---

# Tech Stack

- Java 21
- Spring Boot 3.3.x
- Spring AI 1.0.0-SNAPSHOT
- OpenAI (Chat & DALL·E)

---

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/your-org/ai-client.git
cd ai-client
```

### 2. Configure OpenAI API Key

OpenAI API keys are not free, but new accounts receive $5 credit that is valid for 3 months.  [caution] This is not valid for image generation.

Generate an API key, and add it to the **OPENAI_API_KEY** environment variable.

### 3. Build and Run

```bash
./mvnw spring-boot:run
```

## API Usage

Endpoint:

```http
POST /api/v1/prompt
Content-Type: application/json
```

Request body for text:

```json
{
  "prompt": "Tell me a joke about octopuses",
  "returnType": "TEXT"
}
```

```bash
curl -X POST http://localhost:8080/api/v1/prompt \
  -H "Content-Type: application/json" \
  -d '{
    "prompt": "Tell me a joke about octopuses",
    "returnType": "TEXT"
}'

```
Response:
```json
{
  "prompt": "Tell me a joke about octopuses",
  "returnType": "TEXT",
  "response": "Why did the octopus cross the road? To get to the other tide!"
}
```

Request body for image:
```json
{
  "prompt": "Draw a sunset over the ocean",
  "returnType": "IMAGE"
}
```

Response:
```json
{
  "prompt": "Draw a sunset over the ocean",
  "returnType": "IMAGE",
  "imageUrl": "https://image.openai.com/generated/abc123.png"
}
```

```bash
curl -X POST http://localhost:8080/api/v1/prompt \
  -H "Content-Type: application/json" \
  -d '{
    "prompt": "Draw a sunset over the ocean",
    "returnType": "IMAGE"
}'
```

## Links

[Github repo]()
[Spring AI](https://docs.spring.io/spring-ai/reference/index.html)
[Spring AI Chat models](https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html)
[Spring AI Image generation](https://docs.spring.io/spring-ai/reference/api/image/openai-image.html)
