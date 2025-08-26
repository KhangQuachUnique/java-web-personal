<% request.setAttribute("name", "Quach Thanh Khang");
request.setAttribute("age", 20);
request.setAttribute("university", "HCMUTE");
request.setAttribute("major", "Data Engineering");
request.setAttribute("studentId", "23133033");
request.setAttribute("email", "kadfwfsfsvs@gmail.com");
request.setAttribute("studentEmail", "23133033@student.hcmute.edu.vn");
request.setAttribute("phone", "0916433455");
request.setAttribute("github", "https://github.com/KhangQuachUnique");
request.setAttribute("dob", "09/10/2005");
request.setAttribute("address", "Ho Chi Minh City, Vietnam");
request.setAttribute("skills", new String[]{"Java",
"SQL", "Python", "HTML/CSS", "JavaScript", "Spring Boot"}); %>

<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%= application.getInitParameter("siteTitle") %></title>
    <link rel="stylesheet" href="./index.css" />
  </head>
  <body>
    <div class="container">
      <!-- Navigation -->
      <nav class="navbar">
        <div class="nav-brand">Khang Quach</div>
        <div class="nav-links">
          <a href="#home">Home</a>
          <a href="#about">About</a>
          <a href="#homeworks">Homeworks</a>
          <a href="#contact">Contact</a>
        </div>
      </nav>

      <!-- Hero Section -->
      <section id="home" class="hero">
        <div class="hero-content">
          <div class="hero-text">
            <h1 class="hero-title">
              Hi, I'm
              <span class="gradient-text"> ${name} </span>
            </h1>
            <h2 class="hero-subtitle">${major}</h2>
            <p class="hero-description">
              Hello! I'm a third-year Data Engineering student at HCMUTE. I am
              passionate about web development and always eager to learn new
              technologies. My goal is to become a professional full-stack
              developer.
            </p>
            <div class="hero-buttons">
              <a
                href="${github}"
                class="btn btn-outline"
                target="_blank"
                rel="noopener noreferrer"
                >GitHub Page</a
              >
            </div>
          </div>
          <div class="hero-image">
            <div class="floating-card">
              <img src="./public/avatar.jpg" alt="Avatar" class="avatar" />
              <div class="status-badge">Ready for new projects</div>
            </div>
          </div>
        </div>
      </section>

      <!-- About Section -->
      <section id="about" class="about">
        <div class="section-header">
          <h2>About Me</h2>
          <p>Learn more about me</p>
        </div>
        <div class="about-grid">
          <div class="about-info">
            <h3>Personal Information</h3>
            <div class="info-list">
              <div class="info-item">
                <span class="info-label">Student ID:</span>
                <span class="info-value">${studentId}</span>
              </div>
              <div class="info-item">
                <span class="info-label">Date of Birth:</span>
                <span class="info-value">${dob}</span>
              </div>
              <div class="info-item">
                <span class="info-label">Address:</span>
                <span class="info-value">${address}</span>
              </div>
              <div class="info-item">
                <span class="info-label">Email:</span>
                <span class="info-value">${email}</span>
              </div>
              <div class="info-item">
                <span class="info-label">Student Email:</span>
                <span class="info-value">${studentEmail}</span>
              </div>
            </div>
          </div>
          <div class="about-skills">
            <h3>Skills & Technologies</h3>
            <div class="skills-grid">
              <div class="skill-card"><span>Java</span></div>
              <div class="skill-card"><span>SQL</span></div>
              <div class="skill-card"><span>Python</span></div>
              <div class="skill-card"><span>HTML/CSS</span></div>
              <div class="skill-card"><span>JavaScript</span></div>
              <div class="skill-card"><span>Express</span></div>
              <div class="skill-card"><span>React</span></div>
              <div class="skill-card"><span>Servlet</span></div>
            </div>
          </div>
        </div>
      </section>

      <!-- Homeworks Section -->
      <section id="homeworks" class="homeworks">
        <div class="section-header">
          <h2>Homeworks</h2>
          <p>My assignments and projects</p>
        </div>
        <div class="homeworks-grid">
          <div class="homework-card">
            <h3>Assignment 2</h3>
            <p>Introduction to Java Programming</p>
            <a href="/join" class="btn btn-primary">View Details</a>
          </div>
          <div class="homework-card">
            <h3>Assignment 3</h3>
            <p>Introduction to Java Programming</p>
            <a href="/survey" class="btn btn-primary">View Details</a>
          </div>
        </div>
      </section>

      <!-- Contact Section -->
      <section id="contact" class="contact">
        <div class="section-header">
          <h2>Contact</h2>
          <p>Let's work together!</p>
        </div>
        <div class="contact-content">
          <div class="contact-info">
            <h3>Contact Information</h3>
            <div class="contact-list">
              <a href="mailto:khangquach@example.com" class="contact-item">
                <span>${email}</span>
              </a>
              <a
                href="${github}"
                class="contact-item"
                target="_blank"
                rel="noopener noreferrer"
              >
                <span>My GitHub</span>
              </a>
              <div class="contact-item">
                <span>${address}</span>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Footer -->
      <footer class="footer">
        <p>&copy; 2025 ${name}. All rights reserved.</p>
      </footer>
    </div>
  </body>
</html>
