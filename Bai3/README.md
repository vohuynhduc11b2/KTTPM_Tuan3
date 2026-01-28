# Domain Decomposition - Authentication System

Dự án Spring Boot với chức năng đăng ký và đăng nhập sử dụng kiến trúc Domain Decomposition.

## Cấu trúc dự án

```
Domain_Decomposition/
├── domain/              # Domain layer - Entities và DTOs
│   ├── User.java
│   └── dto/
│       ├── RegisterRequest.java
│       ├── LoginRequest.java
│       └── AuthResponse.java
├── repository/          # Data Access layer
│   └── UserRepository.java
├── service/            # Business Logic layer
│   ├── AuthService.java
│   └── impl/
│       └── AuthServiceImpl.java
├── controller/         # Presentation layer
│   └── AuthController.java
├── config/             # Configuration
│   └── SecurityConfig.java
└── Application.java    # Main class
```

## Công nghệ sử dụng

- Java 21
- Spring Boot 3.2.1
- Spring Data JPA
- Spring Security
- H2 Database (in-memory)
- Lombok
- JUnit 5 & Mockito

## Chạy ứng dụng

### Cách 1: Dùng Maven
```bash
mvn spring-boot:run
```

### Cách 2: Chạy trên IntelliJ IDEA
1. Mở project trong IntelliJ IDEA
2. Đợi Maven import dependencies xong
3. Tìm file `Application.java` trong `src/main/java/Domain_Decomposition/`
4. Click chuột phải vào file → chọn **Run 'Application'**
5. Hoặc click vào icon ▶️ màu xanh bên cạnh `public static void main`

Ứng dụng sẽ chạy tại: http://localhost:8080

## API Endpoints

### 1. Đăng ký (Register)
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}
```

**Response thành công (200 OK):**
```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "message": "Đăng ký thành công"
}
```

### 2. Đăng nhập (Login)
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "testuser",
  "password": "password123"
}
```

**Response thành công (200 OK):**
```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "message": "Đăng nhập thành công"
}
```

## Chạy tests

### Cách 1: Dùng Maven
```bash
mvn test
```

### Cách 2: Chạy tests trên IntelliJ IDEA

#### Chạy tất cả tests:
1. Click chuột phải vào folder `src/test/java`
2. Chọn **Run 'All Tests'** hoặc **Run 'Tests in 'Bai3''**

#### Chạy 1 test class:
1. Mở file test (ví dụ: `AuthServiceTest.java` hoặc `AuthControllerTest.java`)
2. Click chuột phải vào tên class → chọn **Run 'AuthServiceTest'**
3. Hoặc click icon ▶️ màu xanh bên cạnh tên class

#### Chạy 1 test method cụ thể:
1. Mở file test
2. Click chuột phải vào tên method (ví dụ: `testRegisterSuccess()`)
3. Chọn **Run 'testRegisterSuccess()'**
4. Hoặc click icon ▶️ bên cạnh `@Test`

#### Xem kết quả test:
- Cửa sổAPI trên IntelliJ IDEA

### Sử dụng HTTP Client (Built-in)
1. Chạy application trước
2. Tạo file mới: `test-api.http` trong project root
3. Thêm nội dung:

```http
### Đăng ký user mới
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}

### Đăng nhập
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "testuser",
  "password": "password123"
}

### Đăng ký với username đã tồn tại (sẽ lỗi)
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "username": "testuser",
  "email": "another@example.com",
  "password": "password456"
}
```

4. Click vào icon ▶️ màu xanh bên cạnh mỗi request để chạy
5. Xem response ở panel bên phải

### Sử dụng Postman
1. Mở Postman
2. Tạo request mới với method **POST**
3. URL: `http://localhost:8080/api/auth/register`
4. Vào tab **Body** → chọn **raw** → chọn **JSON**
5. Paste JSON request
6. Click **Send**

## Test  **Run** sẽ hiển thị kết quả
- ✅ Màu xanh: test passed
- ❌ Màu đỏ: test failed
- Click vào test failed để xem chi tiết lỗi

## H2 Console

Truy cập H2 Console tại: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (để trống)

## Validation Rules

### Register:
- Username: 3-50 ký tự, không được trống
- Email: định dạng email hợp lệ, không được trống
- Password: tối thiểu 6 ký tự, không được trống

### Login:
- Username: không được trống
- Password: không được trống

## Test Coverage

- **AuthServiceTest**: Unit tests cho business logic
  - Đăng ký thành công
  - Đăng ký với username đã tồn tại
  - Đăng ký với email đã tồn tại
  - Đăng nhập thành công
  - Đăng nhập với username không hợp lệ
  - Đăng nhập với password không đúng

- **AuthControllerTest**: Integration tests cho API endpoints
  - Register thành công
  - Register với dữ liệu không hợp lệ
  - Register với username đã tồn tại
  - Login thành công
  - Login với thông tin không đúng
  - Login với trường để trống
