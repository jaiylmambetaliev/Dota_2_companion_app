import { Routes, Route, Link } from "react-router-dom";
import HeroesPage from "./HeroesPage";
import HeroDetailsPage from "./HeroDetailsPage";
import FavoritesPage from "./FavoritesPage";
import LogoutPage from "./LogoutPage";

function App() {
    return (
        <div
            style={{
                minHeight: "100vh",
                padding: "2rem",
                boxSizing: "border-box",
            }}
        >
            <div
                style={{
                    maxWidth: "1000px",
                    margin: "0 auto",
                    backgroundColor: "rgba(0, 0, 0, 0.6)",
                    borderRadius: "12px",
                    padding: "1.5rem 2rem",
                    position: "relative",
                }}
            >
                {/* Header row: title + logout on the right */}
                <header
                    style={{
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "space-between",
                        marginBottom: "1rem",
                    }}
                >
                    <h1 style={{ margin: 0 }}>Dota 2 Companion</h1>
                    <Link
                        to="/logout"
                        style={{
                            color: "#ff4d4d",
                            textDecoration: "none",
                            fontWeight: 600,
                            border: "1px solid #ff4d4d",
                            padding: "0.25rem 0.75rem",
                            borderRadius: "4px",
                        }}
                    >
                        Log out
                    </Link>
                </header>

                {/* Navigation */}
                <nav style={{ marginBottom: "1rem" }}>
                    <Link to="/" style={{ marginRight: "1rem" }}>
                        Heroes
                    </Link>
                    <Link to="/favorites">Favorites</Link>
                </nav>

                {/* Routes */}
                <Routes>
                    <Route path="/" element={<HeroesPage />} />
                    <Route path="/heroes/:name" element={<HeroDetailsPage />} />
                    <Route path="/favorites" element={<FavoritesPage />} />
                    <Route path="/logout" element={<LogoutPage />} />
                </Routes>
            </div>
        </div>
    );
}

export default App;
