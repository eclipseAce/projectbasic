describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:9528/')
    cy.get('input[name=username]').clear().type('admin')
    cy.get('input[name=password]').clear().type('123456')
    cy.get('button').contains('Login').click()
    cy.get('.avatar-wrapper > i').click()
    cy.get('span').contains('Log Out').click()
  })
})