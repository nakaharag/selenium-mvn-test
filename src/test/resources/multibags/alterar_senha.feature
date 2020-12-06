Feature: Alteracao de senha
  Scenario: Erro na alteracao de senha
    Given que o usuario esteja logado
    And acesse a pagina de Change Password
    When o campo Current Password nao for preenchido com a senha atual
    And o campo New Password for preenchido com uma senha válida
    And o campo Repeat Password for preenchido com a mesma senha do campo anterior
    Then sera exibida uma mensagem de senha invalida