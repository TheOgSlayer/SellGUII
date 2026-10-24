# SellWorth

Paper plugin: `/sell` GUI, `/worth` GUI + `/worth <item>`, and hover worth on items, all driven by `prices.yml`.

**Requires:** Vault + an economy plugin.

## Features
- `/sell` sells items, **including shulker boxes** (box price + everything inside).
- Damaged items sell for less (scaled by durability left, floor set by `damaged-minimum-percent`).
- `/worth` menu with search (sign), sort and pages; `/worth <item>` prints the price in chat + action bar.
- Hover tooltip `Worth: $X` for the whole stack.

## Config
- `prices.yml` - price of ONE item per material. `/sellreload` reloads it.
- `config.yml` - `damaged-minimum-percent`, `shulker-sell-unsellable-contents`.

## Note about NativeWorth
The built-in hover hook is shipped as precompiled classes in
`src/main/resources/dev/sellworth/NativeWorth*.class` (they are copied into the jar by Maven).
If you have its source, put `NativeWorth.java` in `src/main/java/dev/sellworth/` and delete those three `.class` files.

## Building
GitHub Actions builds on every push (Actions tab > latest run > Artifacts). Locally: `mvn package` (JDK 21).
