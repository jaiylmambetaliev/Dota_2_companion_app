import { useState } from "react";

export default function TransferForm() {
    const [senderId, setSenderId] = useState<number>(0);
    const [receiverId, setReceiverId] = useState<number>(0);
    const [amount, setAmount] = useState<number>(0);
    const [message, setMessage] = useState<string>("");

    const submitTransfer = async (e: React.FormEvent) => {
        e.preventDefault();

        const body = {
            senderAccountId: senderId,
            receiverAccountId: receiverId,
            amount: amount,
        };

        try {
            const response = await fetch("http://localhost:8080/transfer", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(body),
            });

            if (response.ok) {
                setMessage("✅ Transfer successful!");
            } else {
                setMessage("❌ Transfer failed (check IDs and balance)");
            }
        } catch (err) {
            console.error(err);
            setMessage("❌ Error connecting to backend");
        }
    };

    return (
        <div style={{ maxWidth: "400px", margin: "2rem auto" }}>
            <h2>Transfer Money</h2>

            <form onSubmit={submitTransfer}>
                <label>
                    Sender Account ID:
                    <input
                        type="number"
                        value={senderId}
                        onChange={(e) => setSenderId(Number(e.target.value))}
                        required
                    />
                </label>
                <br />

                <label>
                    Receiver Account ID:
                    <input
                        type="number"
                        value={receiverId}
                        onChange={(e) => setReceiverId(Number(e.target.value))}
                        required
                    />
                </label>
                <br />

                <label>
                    Amount:
                    <input
                        type="number"
                        step="0.01"
                        value={amount}
                        onChange={(e) => setAmount(Number(e.target.value))}
                        required
                    />
                </label>
                <br />

                <button type="submit" style={{ marginTop: "1rem" }}>
                    Send Transfer
                </button>
            </form>

            {message && <p style={{ marginTop: "1rem" }}>{message}</p>}
        </div>
    );
}
