export interface Hero {
    id: number;
    name: string;
    localized_name: string;
    primary_attr: string;
    attack_type: string;
    roles: string[];
}

export interface HeroDetails {
    id: number;
    name: string;
    localizedName: string;
    primaryAttr: string;
    attackType: string;
    roles: string[];

    baseHealth: number;
    baseMana: number;
    baseArmor: number;
    baseAttackMin: number;
    baseAttackMax: number;
    baseStr: number;
    baseAgi: number;
    baseInt: number;
    moveSpeed: number;
    attackRange: number;
    proPick: number;
    proWin: number;
    turboPicks: number;
    turboWins: number;
}
