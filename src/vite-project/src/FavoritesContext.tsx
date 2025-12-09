import React, { createContext, useContext, useEffect, useState } from "react";

interface FavoritesContextValue {
    favorites: string[]; // hero internal names, e.g. "npc_dota_hero_antimage"
    isFavorite: (name: string) => boolean;
    toggleFavorite: (name: string) => void;
}

const FavoritesContext = createContext<FavoritesContextValue | undefined>(
    undefined
);

const STORAGE_KEY = "favoriteHeroes";

export const FavoritesProvider: React.FC<{ children: React.ReactNode }> = ({
                                                                               children,
                                                                           }) => {
    const [favorites, setFavorites] = useState<string[]>([]);

    // load from localStorage on mount
    useEffect(() => {
        try {
            const raw = localStorage.getItem(STORAGE_KEY);
            if (raw) {
                const parsed = JSON.parse(raw);
                if (Array.isArray(parsed)) {
                    setFavorites(parsed);
                }
            }
        } catch {
            // ignore
        }
    }, []);

    // save to localStorage when favorites change
    useEffect(() => {
        try {
            localStorage.setItem(STORAGE_KEY, JSON.stringify(favorites));
        } catch {
            // ignore
        }
    }, [favorites]);

    const isFavorite = (name: string) => favorites.includes(name);

    const toggleFavorite = (name: string) => {
        setFavorites((prev) =>
            prev.includes(name) ? prev.filter((n) => n !== name) : [...prev, name]
        );
    };

    return (
        <FavoritesContext.Provider value={{ favorites, isFavorite, toggleFavorite }}>
            {children}
        </FavoritesContext.Provider>
    );
};

export const useFavorites = (): FavoritesContextValue => {
    const ctx = useContext(FavoritesContext);
    if (!ctx) {
        throw new Error("useFavorites must be used within a FavoritesProvider");
    }
    return ctx;
};
