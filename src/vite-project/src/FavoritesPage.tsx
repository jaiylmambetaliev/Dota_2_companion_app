import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import type { Hero } from "./types";
import { useFavorites } from "./FavoritesContext";
import defaultHeroIcon from "./assets/default-hero.png";

const FavoritesPage: React.FC = () => {
    const { favorites } = useFavorites();
    const [heroes, setHeroes] = useState<Hero[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

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
        return <p style={{ padding: "1rem" }}>Loading favorites…</p>;
    }

    if (error) {
        return (
            <p style={{ padding: "1rem", color: "red" }}>
                {error}
            </p>
        );
    }

    const favoriteHeroes = heroes.filter((h) => favorites.includes(h.name));

    if (favoriteHeroes.length === 0) {
        return (
            <div style={{ padding: "1rem" }}>
                <h2>Favorite Heroes</h2>
                <p>No favorites yet. Go to the Heroes page and star some heroes!</p>
            </div>
        );
    }

    return (
        <div style={{ maxWidth: "900px", margin: "2rem auto", padding: "0 1rem" }}>
            <h2>Favorite Heroes</h2>
            <ul style={{ listStyle: "none", padding: 0, marginTop: "1rem" }}>
                {favoriteHeroes.map((hero) => (
                    <li
                        key={hero.id}
                        style={{
                            display: "flex",
                            alignItems: "center",
                            gap: "0.75rem",
                            padding: "0.5rem 0",
                            borderBottom: "1px solid #333",
                        }}
                    >
                        <HeroIconSmall hero={hero} />
                        <div>
                            <Link
                                to={`/heroes/${encodeURIComponent(hero.name)}`}
                                style={{ color: "#61dafb", textDecoration: "none" }}
                            >
                                {hero.localized_name}
                            </Link>
                            <div style={{ fontSize: "0.85rem", opacity: 0.8 }}>
                                {hero.roles.join(", ")}
                            </div>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
};

function getHeroSlug(internalName: string): string {
    return internalName.replace("npc_dota_hero_", "");
}

function getHeroIconUrl(hero: Hero): string {
    const slug = getHeroSlug(hero.name);
    return `https://raw.githubusercontent.com/devilesk/dota-webassets/master/images/heroes/${slug}.png`;
}

interface HeroIconSmallProps {
    hero: Hero;
}

const HeroIconSmall: React.FC<HeroIconSmallProps> = ({ hero }) => {
    const [src, setSrc] = useState<string>(getHeroIconUrl(hero));

    return (
        <img
            src={src}
            alt={hero.localized_name}
            width={48}
            height={27}
            style={{ objectFit: "contain" }}
            onError={() => {
                setSrc(defaultHeroIcon);
            }}
        />
    );
};

export default FavoritesPage;
