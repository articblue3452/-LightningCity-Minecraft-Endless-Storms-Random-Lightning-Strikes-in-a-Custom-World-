# ⚡ LightningCity — Turn Your World Into a Stormy Warzone! 🌩️🌧️

![Minecraft Lightning](https://i.imgur.com/Ly4fPtd.gif)

---

## ✨ Overview
**LightningCity** is a fun & chaotic Minecraft plugin that **creates a dedicated lightning-filled world** called **LightningCity** where storms never end and bolts strike players & random spots every few seconds.  
Perfect for **mini-games**, **PvP arenas**, or just spicing up your SMP with some ⚡ *electrifying energy* ⚡.

---

## 🎯 Features
- 🌍 **Auto World Creation** — Instantly creates `LightningCity` world if it doesn't exist.
- ⛈ **Infinite Thunderstorm** — Storms that *never* end.
- 🎯 **Lightning Strikes**:
  - **RANDOM Player Mode** (default)
  - **ALL Player Mode** (shock everyone!)
- 🌎 **Random Location Strikes** — For extra chaos.
- 🎮 **Easy Commands** to control the storm.
- 🔒 **Permission Support** — Only ops or authorized players can control it.

---

## 🕹 Commands & Permissions

| Command | Description | Permission |
|---------|-------------|------------|
| `/lightningcity on` | Enable the plugin’s strikes | `lightningcity.control` |
| `/lightningcity off` | Disable strikes | `lightningcity.control` |
| `/lightningcity mode` | Toggle between Random Player mode & All Players mode | `lightningcity.control` |

> **Note:** Without permission, players can’t control the storm.

---

## 🛠 Installation
1. Download the plugin JAR from [Releases](#) (or build from source).
2. Drop it into your server’s `plugins/` folder.
3. Start your server.
4. Type `/lightningcity on` to unleash the storm! 🌩️

---

## 📂 plugin.yml
```yaml
name: LightningCity
main: server.lightning.Lightning
version: 1.0
api-version: 1.13
author: YourName
commands:
  lightningcity:
    description: Control LightningCity plugin
    usage: /<command> <on|off|mode>
permissions:
  lightningcity.control:
    description: Allows controlling LightningCity
    default: op
```

---

## 🎮 Gameplay Preview
> Imagine… you’re running across a thunderstorm battlefield — and suddenly a bolt hits right next to you.  
> Or worse… directly on your head! ⚡🔥

![Lightning Storm](https://i.imgur.com/zXvTi2n.gif)

---

## 💡 Ideas for Use
- **PvP Arena** — Force players to fight under stormy chaos.
- **Survival Challenge** — Make survival harder & more exciting.
- **Mini-game Mode** — Last one alive wins.

---

## 🧑‍💻 For Developers
- Built using **Spigot API**.
- Compatible with **1.13+ API version**, but runs a dedicated **1.11.2+ LightningCity world**.

---

## 📜 License
This project is free to use and modify — just don’t sell it as your own.  
Let’s keep Minecraft fun & creative. 💖

---

**🔥 Made with love & lightning ⚡ by [YourName]**
