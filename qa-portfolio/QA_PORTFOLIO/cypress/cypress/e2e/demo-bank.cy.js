// Cypress e2e smoke test against Applitools Demo Bank
describe('Demo Bank Smoke', () => {
  it('logs in and sees dashboard', () => {
    cy.visit('https://demo.applitools.com/');
    cy.get('#username').type('user');
    cy.get('#password').type('pass');
    cy.get('#log-in').click();
    cy.url().should('include', 'app.html');
  });
});
