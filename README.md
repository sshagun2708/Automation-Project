# 🤖 Automation_Project: Hybrid Test Automation Framework

**Automation_Project** is an enterprise-grade hybrid UI test automation framework designed by combining the legacy stability and broad cross-browser compatibility of **Selenium WebDriver** with the high-speed execution, modern auto-waiting capabilities, and shadow DOM handling of **Microsoft Playwright**.

---

## 🚀 Key Features

* **Dual-Engine Architecture:** Integrates both **Selenium** and **Playwright**, allowing teams to choose the optimal engine depending on browser requirements or legacy constraints.
* **Page Object Model (POM):** Clean, modular, and maintainable object-oriented structure separating locators/page behavior from core test logic.
* **Smart Synchronization & Locators:** Leverages Playwright's auto-waiting and robust role-based locators alongside Selenium's custom wait handlers to completely eliminate flaky test executions.
* **Cross-Browser & Multi-Tab Support:** Native support for Chromium, Edge, Firefox, and multi-tab context management.

---

## 🛠️ Tech Stack

* **Languages & Runtimes:** Python / Java (depending on module)
* **Automation Engines:** Selenium WebDriver, Microsoft Playwright
* **Design Pattern:** Page Object Model (POM)

---

## 📂 Project Directory Structure

```text
Automation_Project/
│
├── src/                      # Source code and framework components
│   ├── main/java/com/pages/  # Page Object Model classes (Selenium & Playwright)
│   └── ...
├── agents/                   # Orchestration and execution agents
├── inputs.txt                # Test step inputs and configuration
├── requirements.txt          # Python dependencies
└── README.md                 # Project documentation

```

---

## ⚙️ Installation & Setup

1. **Clone the repository:**
```bash
git clone [https://github.com/sshagun2708/Automation-Project.git](https://github.com/sshagun2708/Automation-Project.git)
cd Automation-Project

```


2. **Set up a virtual environment (Python):**
```bash
python -m venv venv
source venv/bin/activate  # On Windows use: venv\Scripts\activate

```


3. **Install dependencies:**
```bash
pip install -r requirements.txt
playwright install

```



---

## 💡 Usage

Configure your test steps, target URLs, and targets inside your input files or execution scripts, then run your automation workflows directly from your local terminal or IDE.

```

```
