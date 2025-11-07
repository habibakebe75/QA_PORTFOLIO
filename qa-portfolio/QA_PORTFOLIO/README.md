
# QA Portfolio — Habiba Kebe

This portfolio contains **runnable** examples to demonstrate functional testing, automation, API testing, and data checks.

## Contents
- `selenium-java/` — JUnit5 Selenium test against a public demo banking app
- `cypress/` — Cypress smoke test (same app)
- `postman/qa-portfolio-postman.json` — Postman collection with basic tests
- `sql/examples.sql` — Sample SQL queries for QA data checks

## How to run (quick)
### Selenium
```bash
cd selenium-java
mvn -q -Dtest=DemoBankLoginTest test
```
### Cypress
```bash
cd cypress
npm install
npm run test
```
### Postman
Import `postman/qa-portfolio-postman.json` and click **Run**.
