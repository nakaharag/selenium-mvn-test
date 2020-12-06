Feature: Login de um usuário

  Scenario Outline: Realizar login no multibags
    Given que tenho acesso a página de login do multibags
    When for inserido o usuario <username> e a senha <password>
    Then a mensagem <message> deve ser exibida

    Examples:
      | username          | password  | message                                            |
      | ""                | "20"      | "Login Failed. Username or Password is incorrect." |
      | "a"               | ""        | "Login Failed. Username or Password is incorrect." |
      | "aaa@gmail.com"   | "20"      | "Login Failed. Username or Password is incorrect." |