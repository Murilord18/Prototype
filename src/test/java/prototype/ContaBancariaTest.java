package prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;


class ContaBancariaTest {


    // Teste 1: clone é independente — dados primitivos/String

    @Test
    void testCloneIndependencia() throws CloneNotSupportedException {
        Agencia agencia = new Agencia("0001", "Agência Centro", "Juiz de Fora");
        ContaBancaria original = new ContaBancaria("12345-6", "Carlos Silva",
                "CORRENTE", 5000.00, agencia);

        ContaBancaria clone = original.clone();

        // Modifica dados do clone
        clone.setNumeroConta("99999-9");
        clone.setTitular("Ana Souza");
        clone.setSaldo(1500.00);

        // Original permanece inalterado
        assertEquals(
                "ContaBancaria{numeroConta='12345-6', titular='Carlos Silva', tipoConta='CORRENTE', saldo=5000.0, agencia=Agencia{codigo='0001', nome='Agência Centro', cidade='Juiz de Fora'}}",
                original.toString()
        );

        // Clone tem os novos valores
        assertEquals(
                "ContaBancaria{numeroConta='99999-9', titular='Ana Souza', tipoConta='CORRENTE', saldo=1500.0, agencia=Agencia{codigo='0001', nome='Agência Centro', cidade='Juiz de Fora'}}",
                clone.toString()
        );
    }


    // Teste 2: deep copy — Agencia do clone é objeto distinto

    @Test
    void testDeepCopyAgencia() throws CloneNotSupportedException {
        Agencia agencia = new Agencia("0002", "Agência Norte", "Belo Horizonte");
        ContaBancaria original = new ContaBancaria("55555-5", "Pedro Lima",
                "POUPANCA", 3000.00, agencia);

        ContaBancaria clone = original.clone();

        // Modifica a agência do clone
        clone.getAgencia().setCodigo("0099");
        clone.getAgencia().setNome("Agência Sul");
        clone.getAgencia().setCidade("São Paulo");

        // Agência do original NÃO deve ter sido alterada
        assertEquals(
                "ContaBancaria{numeroConta='55555-5', titular='Pedro Lima', tipoConta='POUPANCA', saldo=3000.0, agencia=Agencia{codigo='0002', nome='Agência Norte', cidade='Belo Horizonte'}}",
                original.toString()
        );

        // Agência do clone deve refletir as mudanças
        assertEquals(
                "ContaBancaria{numeroConta='55555-5', titular='Pedro Lima', tipoConta='POUPANCA', saldo=3000.0, agencia=Agencia{codigo='0099', nome='Agência Sul', cidade='São Paulo'}}",
                clone.toString()
        );
    }


    // Teste 3: clone com tipo de conta diferente (Poupança → Investimento)

    @Test
    void testCloneAlteraTipoConta() throws CloneNotSupportedException {
        Agencia agencia = new Agencia("0003", "Agência Leste", "Rio de Janeiro");
        ContaBancaria original = new ContaBancaria("77777-7", "Mariana Costa",
                "POUPANCA", 10000.00, agencia);

        ContaBancaria clone = original.clone();
        clone.setNumeroConta("88888-8");
        clone.setTipoConta("INVESTIMENTO");
        clone.setSaldo(20000.00);

        // Original: POUPANCA
        assertEquals(
                "ContaBancaria{numeroConta='77777-7', titular='Mariana Costa', tipoConta='POUPANCA', saldo=10000.0, agencia=Agencia{codigo='0003', nome='Agência Leste', cidade='Rio de Janeiro'}}",
                original.toString()
        );

        // Clone: INVESTIMENTO
        assertEquals(
                "ContaBancaria{numeroConta='88888-8', titular='Mariana Costa', tipoConta='INVESTIMENTO', saldo=20000.0, agencia=Agencia{codigo='0003', nome='Agência Leste', cidade='Rio de Janeiro'}}",
                clone.toString()
        );
    }


    // Teste 4: clone não é a mesma referência de objeto

    @Test
    void testCloneReferenciasDiferentes() throws CloneNotSupportedException {
        Agencia agencia = new Agencia("0004", "Agência Oeste", "Curitiba");
        ContaBancaria original = new ContaBancaria("11111-1", "Fernando Neves",
                "CORRENTE", 7500.00, agencia);

        ContaBancaria clone = original.clone();

        // Objetos diferentes na memória
        assertNotSame(original, clone);
        assertNotSame(original.getAgencia(), clone.getAgencia());
    }
}
