package org.ergoplatform.appkit;

import java.util.List;

/**
 * This interface represents a transaction which is signed by a prover
 * and can be sent to blockchain.
 * All inputs of the signed transaction has attached signatures (aka proofs)
 * which evidence that the prover knows the required secretes.
 *
 * @see ErgoProver
 * @see UnsignedTransaction
 */
public interface SignedTransaction {
    /**
     * Transaction if as Base16 string.
     */
    String getId();

    /**
     * Json representation of this transaction.
     */
    String toJson(boolean prettyPrint);

    /**
     * All signed inputs which will be spent when this transaction will be included in the blockchain.
     */
    List<SignedInput> getSignedInputs();

    /**
     * Outputs of this transaction represented as {@link InputBox} objects read to be spent in the next
     * chained transaction.
     * This method can be used to create a chain of transactions. Thus {@code tx1.getOutputsToSpend()} returns
     * a list of boxes which are ready to be included as input boxes to a new tx2.
     */
    List<InputBox> getOutputsToSpend();
}

