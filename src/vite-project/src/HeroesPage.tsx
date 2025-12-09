import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import type { Hero } from "./types";
import defaultHeroIcon from "./assets/default-hero.png";
import { useFavorites } from "./FavoritesContext";

const HeroesPage: React.FC = () => {
    const [heroes, setHeroes] = useState<Hero[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { isFavorite, toggleFavorite } = useFavorites();

    useEffect(() => {
        const fetchHeroes = async () => {
            try {
                const res = await fetch("/api/heroes");

                if (!res.ok) {
                    throw new Error(`HTTP ${res.status}`);
                }

                const data: Hero[] = await res.json();
                setHeroes(data);
            } catch (err) {
                console.error(err);
                setError("Failed to load heroes");
            } finally {
                setLoading(false);
            }
        };

        fetchHeroes();
    }, []);

    if (loading) {
        return <p style={{ padding: "1rem" }}>Loading heroes…</p>;
    }

    if (error) {
        return (
            <p style={{ padding: "1rem", color: "red" }}>
                {error}
            </p>
        );
    }

    return (
        <div style={{ maxWidth: "900px", margin: "2rem auto", padding: "0 1rem" }}>
            <h2>Dota 2 Heroes</h2>
            <table
                style={{
                    width: "100%",
                    borderCollapse: "collapse",
                    marginTop: "1rem",
                }}
            >
                <thead>
                <tr>
                    <th style={th}>Icon</th>
                    <th style={th}>Name</th>
                    <th style={th}>Primary Attr</th>
                    <th style={th}>Attack Type</th>
                    <th style={th}>Roles</th>
                    <th style={th}>Favorite</th>
                </tr>
                </thead>
                <tbody>
                {heroes.map((hero) => {
                    const fav = isFavorite(hero.name);
                    return (
                        <tr key={hero.id}>
                            <td style={td}>
                                <HeroIcon hero={hero} />
                            </td>
                            <td style={td}>
                                <Link
                                    to={`/heroes/${encodeURIComponent(hero.name)}`}
                                    style={{ color: "#61dafb", textDecoration: "none" }}
                                >
                                    {hero.localized_name}
                                </Link>
                            </td>
                            <td style={td}>{hero.primary_attr}</td>
                            <td style={td}>{hero.attack_type}</td>
                            <td style={td}>{hero.roles.join(", ")}</td>
                            <td style={{ ...td, textAlign: "center" as const }}>
                                <button
                                    type="button"
                                    onClick={() => toggleFavorite(hero.name)}
                                    style={{
                                        background: "none",
                                        border: "none",
                                        cursor: "pointer",
                                        fontSize: "1.4rem",
                                        color: "#ffd700",
                                    }}
                                    aria-label={fav ? "Remove from favorites" : "Add to favorites"}
                                >
                                    {fav ? "★" : "☆"}
                                </button>
                            </td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        </div>
    );
};

// helper: strip "npc_dota_hero_" and return slug like "antimage"
function getHeroSlug(internalName: string): string {
    return internalName.replace("npc_dota_hero_", "");
}

// builds the GitHub raw URL for the hero icon
function getHeroIconUrl(hero: Hero): string {
    const slug = getHeroSlug(hero.name);
    // files in: https://github.com/devilesk/dota-webassets/tree/master/images/heroes
    return `https://raw.githubusercontent.com/devilesk/dota-webassets/master/images/heroes/${slug}.png`;
}

interface HeroIconProps {
    hero: Hero;
}

const HeroIcon: React.FC<HeroIconProps> = ({ hero }) => {
    const [src, setSrc] = useState<string>(getHeroIconUrl(hero));

    return (
        <img
            src={src}
            alt={hero.localized_name}
            width={48}
            height={27}
            style={{ objectFit: "contain" }}
            onError={() => {
                // if the GitHub image doesn’t exist, fall back to local default
                setSrc(defaultHeroIcon);
            }}
        />
    );
};

const th = {
    borderBottom: "2px solid #ccc",
    padding: "8px",
    textAlign: "left" as const,
};

const td = {
    borderBottom: "1px solid #ddd",
    padding: "8px",
};

export default HeroesPage;
