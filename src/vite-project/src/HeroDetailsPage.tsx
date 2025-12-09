import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import type { HeroDetails } from "./types";
import defaultHeroIcon from "./assets/default-hero.png";
import { useFavorites } from "./FavoritesContext";

const HeroDetailsPage: React.FC = () => {
    const { name } = useParams<{ name: string }>();
    const [details, setDetails] = useState<HeroDetails | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { isFavorite, toggleFavorite } = useFavorites();

    useEffect(() => {
        const fetchDetails = async () => {
            if (!name) return;
            try {
                const res = await fetch(`/api/heroes/name/${encodeURIComponent(name)}`);
                if (!res.ok) {
                    throw new Error(`HTTP ${res.status}`);
                }
                const data: HeroDetails = await res.json();
                setDetails(data);
            } catch (err) {
                console.error(err);
                setError("Failed to load hero details");
            } finally {
                setLoading(false);
            }
        };

        fetchDetails();
    }, [name]);

    if (loading) {
        return <p style={{ padding: "1rem" }}>Loading hero details…</p>;
    }

    if (error || !details) {
        return (
            <div style={{ padding: "1rem" }}>
                <p style={{ color: "red" }}>{error ?? "Hero not found"}</p>
                <Link to="/">← Back to heroes</Link>
            </div>
        );
    }

    const fav = isFavorite(details.name);

    return (
        <div style={{ padding: "1rem" }}>
            <Link to="/">← Back to heroes</Link>

            {/* Header with icon + name + favorite button */}
            <div
                style={{
                    display: "flex",
                    alignItems: "center",
                    gap: "1rem",
                    marginTop: "1rem",
                    marginBottom: "0.5rem",
                }}
            >
                <HeroIconBig internalName={details.name} alt={details.localizedName} />

                <div style={{ flexGrow: 1 }}>
                    <h2 style={{ margin: 0 }}>{details.localizedName}</h2>
                    <div style={{ fontSize: "0.9rem", opacity: 0.8 }}>
                        {details.name}
                    </div>
                </div>

                <button
                    type="button"
                    onClick={() => toggleFavorite(details.name)}
                    style={{
                        background: "none",
                        border: "1px solid #ffd700",
                        borderRadius: "4px",
                        padding: "0.25rem 0.75rem",
                        cursor: "pointer",
                        display: "flex",
                        alignItems: "center",
                        gap: "0.3rem",
                        color: "#ffffff",
                    }}
                >
                  <span style={{fontSize: "1.2rem", color: "#ffd700"}}>
                    {fav ? "★" : "☆"} {}
                  </span>
                    <span>{fav ? "Remove Favorite" : "Add Favorite"}</span>
                </button>

            </div>

            <p>
                <strong>Primary Attr:</strong> {details.primaryAttr} |{" "}
                <strong>Attack Type:</strong> {details.attackType}
            </p>
            <p>
                <strong>Roles:</strong> {details.roles.join(", ")}
            </p>

            <h3>Base Stats</h3>
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "repeat(auto-fit, minmax(180px, 1fr))",
                    gap: "0.75rem",
                    marginTop: "0.5rem",
                }}
            >
                <StatCard label="Base Health" value={details.baseHealth} />
                <StatCard label="Base Mana" value={details.baseMana} />
                <StatCard label="Base Armor" value={details.baseArmor} />
                <StatCard label="Base Attack Min" value={details.baseAttackMin} />
                <StatCard label="Base Attack Max" value={details.baseAttackMax} />
                <StatCard label="Base STR" value={details.baseStr} />
                <StatCard label="Base AGI" value={details.baseAgi} />
                <StatCard label="Base INT" value={details.baseInt} />
                <StatCard label="Move Speed" value={details.moveSpeed} />
                <StatCard label="Attack Range" value={details.attackRange} />
            </div>

            <h3 style={{ marginTop: "1.5rem" }}>Pick / Win</h3>
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
                    gap: "0.75rem",
                }}
            >
                <StatCard label="Pro Picks" value={details.proPick} />
                <StatCard label="Pro Wins" value={details.proWin} />
                <StatCard label="Turbo Picks" value={details.turboPicks} />
                <StatCard label="Turbo Wins" value={details.turboWins} />
            </div>
        </div>
    );
};

interface StatCardProps {
    label: string;
    value: number;
}

const StatCard: React.FC<StatCardProps> = ({ label, value }) => (
    <div
        style={{
            backgroundColor: "rgba(0, 0, 0, 0.5)",
            borderRadius: "8px",
            padding: "0.75rem 1rem",
            border: "1px solid rgba(255, 255, 255, 0.1)",
        }}
    >
        <div style={{ fontSize: "0.85rem", opacity: 0.8 }}>{label}</div>
        <div style={{ fontSize: "1.1rem", fontWeight: 600 }}>{value}</div>
    </div>
);

/** ---- Icon helpers ---- */

function getHeroSlug(internalName: string): string {
    return internalName.replace("npc_dota_hero_", "");
}

function getHeroIconUrl(internalName: string): string {
    const slug = getHeroSlug(internalName);
    return `https://raw.githubusercontent.com/devilesk/dota-webassets/master/images/heroes/${slug}.png`;
}

interface HeroIconBigProps {
    internalName: string;
    alt: string;
}

const HeroIconBig: React.FC<HeroIconBigProps> = ({ internalName, alt }) => {
    const [src, setSrc] = useState<string>(getHeroIconUrl(internalName));

    return (
        <img
            src={src}
            alt={alt}
            width={96}
            height={54}
            style={{ objectFit: "contain", borderRadius: 4 }}
            onError={() => {
                setSrc(defaultHeroIcon);
            }}
        />
    );
};

export default HeroDetailsPage;
